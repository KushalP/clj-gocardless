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
      (testing "get-details"
        (is (= "Tom"
               (-> (with-merchant "WOQRUJU9OH2HH1" (get-details))
                   :first_name))))
      (testing "get-users"
        (is (= "customer40@gocardless.com"
               (-> (with-merchant "WOQRUJU9OH2HH1" (get-users))
                   first
                   :email)))))))
