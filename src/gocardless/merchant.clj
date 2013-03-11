(ns gocardless.merchant)

(defonce ^:dynamic *gocardless-merchant* nil)

(defmacro with-merchant
  "Binds the specified Go Cardless merchant id to the gocardless-merchant variable and executes the body."
  [id & body]
  `(binding [*gocardless-merchant* ~id] ~@body))
