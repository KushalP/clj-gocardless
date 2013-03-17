(ns clj-gocardless.merchant
  (:use clj-gocardless.account)
  (:require [clj-gocardless.network :as network]))

(defonce ^:dynamic *gocardless-merchant* nil)

(defmacro with-merchant
  "Binds the specified Go Cardless merchant id to the gocardless-merchant variable and executes the body."
  [id & body]
  `(binding [*gocardless-merchant* ~id] ~@body))

(defn get-details
  []
  (network/get-json
   (str *gocardless-url* api-path "/merchants/" *gocardless-merchant*)))

(defn get-users
  ([]
     (network/get-json
      (str *gocardless-url* api-path "/merchants/" *gocardless-merchant* "/users")))
  ([id]
     (network/get-json
      (str *gocardless-url* api-path "/merchants/" *gocardless-merchant* "/users" "/" id))))

(defn get-subscriptions
  []
  (network/get-json
   (str *gocardless-url* api-path "/merchants/" *gocardless-merchant* "/subscriptions")))

(defn get-bills
  []
  (network/get-json
   (str *gocardless-url* api-path "/merchants/" *gocardless-merchant* "/bills")))
