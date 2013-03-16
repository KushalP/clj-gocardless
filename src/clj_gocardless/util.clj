(ns clj-gocardless.util
  (:use clojure.walk)
  (:require [clj-http.client :as client]))

(defn get [url]
  (-> url
      (client/get)
      (keywordize-keys)
      :body))
