(ns gocardless.account-test
  (:use clojure.test
        gocardless.bill))

(deftest create-a-bill
  (testing "pre-condition makes sure we're passing in BigDecimals"
    (is (thrown? AssertionError (create-bill :name "not a BigDecimal" :amount "this fails"))))
  (testing "passes and builds out the map"
    (is (= {:name "Test", :amount 1.34M} (create-bill :name "Test" :amount (bigdec 1.34))))))
