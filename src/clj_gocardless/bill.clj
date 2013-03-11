(ns clj-gocardless.bill)

(defonce bill-endpoint "/bills/%s")

(defn create-bill
  [amount & {:keys [name description]}]
  {:pre [(decimal? amount)]}
  {:name name
   :amount amount
   :description description})
