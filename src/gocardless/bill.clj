(ns gocardless.bill)

(defonce bill-endpoint "/bills/%s")

(defn create-bill
  [& {:keys [name amount]}]
  {:pre [(decimal? amount)]}
  {:name name
   :amount amount})
