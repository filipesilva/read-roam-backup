# Read Roam Backup


## Pre-requisites

You’ll need to have [Node 10.16.0 or later](https://nodejs.org/en/), and a [Java SDK](https://adoptopenjdk.net/) (Version 8+, Hotspot).

## Building the script

- `npm install`
- `npm run build`

## Running the script

```sh
node ./out/load-edn.js <relative path to edn backup>
```

Included is a sample empty Roam graph that you can load via `node ./out/load-edn.js ./sample/empty.edn`.

## Editing the script

As is, the script will print the contents of the backup back after loading it, showing a message if it can't be loaded.

This is generally not very useful. Instead you'll want to edit the code in `src/main/load_edn.cljs` to do something with the backup.

The script is written in [ClojureScript](https://clojurescript.org/), and the backup is loaded onto a [DataScript](https://github.com/tonsky/datascript) database. 

You shouldn't need to tweak build settings in general, but if you do, the code is built using [Shadow-CLJS](https://shadow-cljs.github.io/docs/UsersGuide.html) and runs on NodeJS.
