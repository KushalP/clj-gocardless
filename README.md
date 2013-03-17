# clj-gocardless

[![Build Status](https://travis-ci.org/KushalP/clj-gocardless.png?branch=master)](https://travis-ci.org/KushalP/clj-gocardless)

clj-gocardless is a library that provides Clojure bindings for the Go
Cardless API. For a detailed explanation of the available operations
and parameters visit: https://gocardless.com/docs/api_guide

## Usage

Only basic merchant `GET` requests are available at the moment.

```clojure
(:require [clj-gocardless.merchant :as merchant])

(merchant/with-merchant "WOQRUJU9OH2HH1"
  (merchant/details))

(merchant/with-merchant "WOQRUJU9OH2HH1"
  (merchant/users))

(merchant/with-merchant "WOQRUJU9OH2HH1"
  (merchant/users 1))

(merchant/with-merchant "WOQRUJU9OH2HH1"
  (merchant/subscriptions))
```

## License

Copyright © 2013 Kushal Pisavadia

Distributed under the Eclipse Public License, the same as Clojure.
