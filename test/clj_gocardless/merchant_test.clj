(ns clj-gocardless.merchant-test
  (:use clojure.test
        clj-gocardless.merchant)
  (:require [betamax.core :as betamax]))

(deftest binds-with-merchant
  (testing "merchant it is nil when accessed directly"
    (is (nil? *gocardless-merchant*)))
  (testing "merchant id is set within macro"
    (let [id {:id "test"}]
      (with-merchant id
        (is (= (id *gocardless-merchant*)))))))

(deftest ^{:integration true} merchant-integration
  (betamax/with-cassette "gocardless-merchant"
    (testing "merchant operations"
      (testing "details"
        (is (= "Tom"
               (-> (with-merchant "WOQRUJU9OH2HH1" (details))
                   :first_name))))
      (testing "users"
        (is (= "customer40@gocardless.com"
               (-> (with-merchant "WOQRUJU9OH2HH1" (users))
                   first
                   :email)))
        (is (= "customer40@gocardless.com"
               (-> (with-merchant "WOQRUJU9OH2HH1" (users 1))
                   :email))))
      (testing "subscriptions"
        (is (= "London Gym Membership"
               (-> (with-merchant "WOQRUJU9OH2HH1" (subscriptions))
                   first
                   :name))))
      (testing "bills"
        (is (= "GBP"
               (-> (with-merchant "WOQRUJU9OH2HH1" (bills))
                   first
                   :currency)))))))
