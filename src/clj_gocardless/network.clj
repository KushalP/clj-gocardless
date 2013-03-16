(ns clj-gocardless.network
  (:require [clj-http.client :as client]
            [cheshire.core :refer :all]))

(defn get-json [url]
  (-> url
      (client/get)
      :body
      (parse-string true)))
