(ns gocardless.merchant
  (:use clojure.walk
        gocardless.account)
  (:require [clj-http.client :as client]))

(defonce ^:dynamic *gocardless-merchant* nil)

(defmacro with-merchant
  "Binds the specified Go Cardless merchant id to the gocardless-merchant variable and executes the body."
  [id & body]
  `(binding [*gocardless-merchant* ~id] ~@body))

(defn get-details
  []
  (-> (str *gocardless-url* api-path "/merchants/" *gocardless-merchant*)
      (client/get)
      (keywordize-keys)))

(defn get-users
  []
  (-> (str *gocardless-url* api-path "/merchants/" *gocardless-merchant* "/users")
      (client/get)
      (keywordize-keys)))
