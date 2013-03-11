(ns clj-gocardless.bill-test
  (:use clojure.test
        clj-gocardless.bill))

(deftest create-a-bill
  (testing "pre-condition makes sure we're passing in BigDecimals"
    (is (thrown? AssertionError (create-bill "this fails" :name "not a BigDecimal"))))
  (testing "passes and builds out the map"
    (is (= {:name "Test" :amount 1.34M :description nil}
           (create-bill (bigdec 1.34) :name "Test")))))
