#! /bin/sh
numactl --interleave=all /usr/local/mongodb/bin/mongod -f /data/mongodb/data/shard0/r0/conf/mongo.conf
numactl --interleave=all /usr/local/mongodb/bin/mongod -f /data/mongodb/data/shard0/r1/conf/mongo.conf
numactl --interleave=all /usr/local/mongodb/bin/mongod -f /data/mongodb/data/shard0/r2/conf/mongo.conf

numactl --interleave=all /usr/local/mongodb/bin/mongod -f /data/mongodb/data/shard1/r0/conf/mongo.conf
numactl --interleave=all /usr/local/mongodb/bin/mongod -f /data/mongodb/data/shard1/r1/conf/mongo.conf
numactl --interleave=all /usr/local/mongodb/bin/mongod -f /data/mongodb/data/shard1/r2/conf/mongo.conf

numactl --interleave=all /usr/local/mongodb/bin/mongod -f /data/mongodb/data/shard2/r0/conf/mongo.conf
numactl --interleave=all /usr/local/mongodb/bin/mongod -f /data/mongodb/data/shard2/r1/conf/mongo.conf
numactl --interleave=all /usr/local/mongodb/bin/mongod -f /data/mongodb/data/shard2/r2/conf/mongo.conf

numactl --interleave=all /usr/local/mongodb/bin/mongod -f /data/mongodb/config/config0/conf/mongo.conf
numactl --interleave=all /usr/local/mongodb/bin/mongod -f /data/mongodb/config/config1/conf/mongo.conf
numactl --interleave=all /usr/local/mongodb/bin/mongod -f /data/mongodb/config/config2/conf/mongo.conf

numactl --interleave=all /usr/local/mongodb/bin/mongos -f /data/mongodb/mongos/conf/mongo.conf
