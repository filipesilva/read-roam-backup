(ns load-edn
  (:require [cljs.tools.reader.edn :as edn]
            [datascript.core :as d]
            ["fs" :as fs]
            ["path" :as path]))

(defn main [backup-path]
  (let [;; Load the backup from the file system.
        backup-str (fs/readFileSync (path/join (js/process.cwd) backup-path) "utf-8")
        ;; Read the backup as an EDN string.
        backup-db  (try (edn/read-string {:readers d/data-readers} backup-str)
                        (catch :default _ nil))]
    ;; Check the backup is a valid DataScript database.
    (if-not (d/db? backup-db)
      (print "Was not able to read backup. Are you sure it's a valid EDN backup?")
      (let [conn (d/conn-from-db backup-db)]
        ;; Print the contents of the backup.
        ;; conn is a DataScript connection (https://github.com/tonsky/datascript).
        ;; You can perform queries here as well and print the result of those instead.
        (print conn)))))