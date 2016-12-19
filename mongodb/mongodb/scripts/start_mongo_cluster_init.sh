 
echo 'never' /sys/kernel/mm/transparent_hugepage/defrag

numactl --interleave=all /usr/local/mongodb/bin/mongod -f /data/mongodb/data/shard0/r0/conf/mongo.conf

numactl --interleave=all /usr/local/mongodb/bin/mongod -f /data/mongodb/data/shard0/r1/conf/mongo.conf

numactl --interleave=all /usr/local/mongodb/bin/mongod -f /data/mongodb/data/shard0/r2/conf/mongo.conf

/usr/local/mongodb/bin/mongo 127.0.0.1:10000/admin

config={_id: 'shard0', members: [{_id: 0, host: '127.0.0.1:10000', priority : 1}, {_id: 1, host: '127.0.0.1:10001',priority : 1}, {_id: 2, host: '127.0.0.1:10002',arbiterOnly:true}]}

rs.initiate(config); 




numactl --interleave=all /usr/local/mongodb/bin/mongod -f /data/mongodb/data/shard1/r0/conf/mongo.conf

numactl --interleave=all /usr/local/mongodb/bin/mongod -f /data/mongodb/data/shard1/r1/conf/mongo.conf

numactl --interleave=all /usr/local/mongodb/bin/mongod -f /data/mongodb/data/shard1/r2/conf/mongo.conf

/usr/local/mongodb/bin/mongo 127.0.0.1:20000/admin

config={_id: 'shard1', members: [{_id: 0, host: '127.0.0.1:20000', priority : 1}, {_id: 1, host: '127.0.0.1:20001', priority : 2}, {_id: 2, host: '127.0.0.1:20002',arbiterOnly:true}]}

rs.initiate(config); 



numactl --interleave=all /usr/local/mongodb/bin/mongod -f /data/mongodb/data/shard2/r0/conf/mongo.conf

numactl --interleave=all /usr/local/mongodb/bin/mongod -f /data/mongodb/data/shard2/r1/conf/mongo.conf

numactl --interleave=all /usr/local/mongodb/bin/mongod -f /data/mongodb/data/shard2/r2/conf/mongo.conf


/usr/local/mongodb/bin/mongo 127.0.0.1:30000/admin

config={_id: 'shard2', members: [{_id: 0, host: '127.0.0.1:30000', priority : 1}, {_id: 1, host: '127.0.0.1:30001', priority : 2}, {_id: 2, host: '127.0.0.1:30002',arbiterOnly:true}]}

rs.initiate(config); 



numactl --interleave=all /usr/local/mongodb/bin/mongod -f /data/mongodb/config/config0/conf/mongo.conf

numactl --interleave=all /usr/local/mongodb/bin/mongod -f /data/mongodb/config/config1/conf/mongo.conf

numactl --interleave=all /usr/local/mongodb/bin/mongod -f /data/mongodb/config/config2/conf/mongo.conf



numactl --interleave=all /usr/local/mongodb/bin/mongos -f /data/mongodb/mongos/conf/mongo.conf


/usr/local/mongodb/bin/mon 127.0.0.1:50000/admin

db.runCommand({addshard:"shard0/127.0.0.1:10000,127.0.0.1:10001,127.0.0.1:10002",name:"ShardSetA"})  
db.runCommand({addshard:"shard1/127.0.0.1:20000,127.0.0.1:20001,127.0.0.1:20002",name:"ShardSetB"})  
db.runCommand({addshard:"shard2/127.0.0.1:30000,127.0.0.1:30001,127.0.0.1:30002",name:"ShardSetC"}) 