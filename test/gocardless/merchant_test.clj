(ns gocardless.account-test
  (:use clojure.test
        gocardless.merchant))

(deftest binds-with-merchant
  (testing "merchant it is nil when accessed directly"
    (is (nil? *gocardless-merchant*)))
  (testing "merchant id is set within macro"
    (let [id {:id "test"}]
      (with-merchant id
        (is (= (id *gocardless-merchant*)))))))
