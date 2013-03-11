(ns clj-gocardless.account-test
  (:use clojure.test
        clj-gocardless.account))

(deftest binds-with-account
  (testing "account is nil when accessed directly"
    (is (nil? *gocardless-account*)))
  (testing "account is set within macro"
    (let [account {:app_id "X" :app_secret "X" :token "X manage_merchant:1"}]
      (with-account account
        (is (= (account *gocardless-account*)))))))
