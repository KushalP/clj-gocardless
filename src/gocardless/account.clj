(ns gocardless.account)

(defonce ^:dynamic *gocardless-account* nil)

(defmacro with-account
  "Binds the specified Go Cardless account to the gocardless-account variable and executes the body."
  [account & body]
  `(binding [*gocardless-account* ~account] ~@body))
