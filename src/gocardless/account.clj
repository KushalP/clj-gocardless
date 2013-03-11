(ns gocardless.account)

(defonce ^:dynamic *gocardless-account* nil)

(defonce ^:dynamic *gocardless-merchant* nil)

(defonce ^:dynamic *gocardless-url* "https://gocardless.com")

(defonce api-path "/api/v1")

(defmacro with-account
  "Binds the specified Go Cardless account to the gocardless-account variable and executes the body."
  [account & body]
  `(binding [*gocardless-account* ~account] ~@body))

(defmacro with-merchant
  "Binds the specified Go Cardless merchant id to the gocardless-merchant variable and executes the body."
  [id & body]
  `(binding [*gocardless-merchant* ~id] ~@body))
