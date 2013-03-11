(ns gocardless.merchant-test
  (:use clojure.test
        gocardless.merchant)
  (:require [betamax.core :as betamax]))

(deftest binds-with-merchant
  (testing "merchant it is nil when accessed directly"
    (is (nil? *gocardless-merchant*)))
  (testing "merchant id is set within macro"
    (let [id {:id "test"}]
      (with-merchant id
        (is (= (id *gocardless-merchant*)))))))

(deftest ^{:integration true} merchant-operations
  (testing "get-details"
    (betamax/with-cassette "gocardless-merchant"
      (let [details (with-merchant "WOQRUJU9OH2HH1" (get-details))]
        (is (= "Tom" (:first_name (:body details))))))))
