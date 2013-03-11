(defproject gocardless "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [clj-http "0.6.5"]]
  :profiles {:dev {:dependencies [[betamax "0.1.3"]]}}
  :test-selectors {:default (constantly true)})
