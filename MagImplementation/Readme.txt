
This program takes in data something like mentioned below as a text file, that contains a json data.
After processing the data, we get corresponding Neo4J Statemnent as highlighted below in Output Generated section below.


Input File: (mag.txt)


[
{
  "title": "System and Method for Maskless Direct Write Lithography",
  "lang": "en",
  "year": 2015,
  "references": [
    "354c172f-d877-4e60-a7eb-c1b1cf03ce4d",
    "76cf1064-b2b2-4245-940b-4e25dab9d41d"
  ],
  "abstract": "A system and method for maskless direct write lithography are disclosed. The method includes receiving a plurality of pixels that represent an integrated circuit (IC) layout; identifying a first subset of the pixels that are suitable for a first compression method; and identifying a second subset of the pixels that are suitable for a second compression method. The method further includes compressing the first and second subset using the first and second compression method respectively, resulting in compressed data. The method further includes delivering the compressed data to a maskless direct writer for manufacturing a substrate. In embodiments, the first compression method uses a run-length encoding and the second compression method uses a dictionary-based encoding. Due to the hybrid compression method, the compressed data can be decompressed with a data rate expansion ratio sufficient for high-volume IC manufacturing.",
  "url": [
    "http://www.freepatentsonline.com/y2016/0211117.html",
    "http://www.google.com/patents/US20160211117",
    "https://www.google.de/patents/US20160211117"
  ],
  "id": "0000002e-c2f2-4e25-9341-60d39130ac7a",
  "fos": [
    "Electronic engineering",
    "Computer hardware",
    "Engineering",
    "Engineering drawing"
  ]
}
]




Output Generated: 


[WITH count(*) as dummy
MERGE (a:Node {title: System and Method for Maskless Direct Write Lithography})
MERGE (b:Node {lang: 0000002e-c2f2-4e25-9341-60d39130ac7a})
MERGE (c:Node {year: 2015})
MERGE (d:Node {references: ["354c172f-d877-4e60-a7eb-c1b1cf03ce4d","76cf1064-b2b2-4245-940b-4e25dab9d41d"]})
MERGE (e:Node {abstract: A system and method for maskless direct write lithography are disclosed. The method includes receiving a plurality of pixels that represent an integrated circuit (IC) layout; identifying a first subset of the pixels that are suitable for a first compression method; and identifying a second subset of the pixels that are suitable for a second compression method. The method further includes compressing the first and second subset using the first and second compression method respectively, resulting in compressed data. The method further includes delivering the compressed data to a maskless direct writer for manufacturing a substrate. In embodiments, the first compression method uses a run-length encoding and the second compression method uses a dictionary-based encoding. Due to the hybrid compression method, the compressed data can be decompressed with a data rate expansion ratio sufficient for high-volume IC manufacturing.})
MERGE (f:Node {url: ["http:\/\/www.freepatentsonline.com\/y2016\/0211117.html","http:\/\/www.google.com\/patents\/US20160211117","https:\/\/www.google.de\/patents\/US20160211117"]})
MERGE (g:Node {id: 0000002e-c2f2-4e25-9341-60d39130ac7a})
MERGE (h:Node {fos: ["Electronic engineering","Computer hardware","Engineering","Engineering drawing"]})
CREATE (a)-[:LINK]->(b)]
