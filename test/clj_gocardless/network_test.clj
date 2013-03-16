(ns clj-gocardless.network-test
  (:use clojure.test
        clj-gocardless.network)
  (:require [betamax.core :as betamax]))

(deftest ^{:integration true} get-requests
  (betamax/with-cassette "network-requests"
    (is (= {:test "json"} (get-json "http://violentlymild.com/sample.json")))))
