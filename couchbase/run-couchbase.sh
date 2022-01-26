docker build -t muratavci/couchbase .
docker run -d -p 8091-8093:8091-8093 -p 11210:11210 muratavci/couchbase