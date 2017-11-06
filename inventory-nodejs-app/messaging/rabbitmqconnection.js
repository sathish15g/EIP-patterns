/*var amqp = require('amqplib/callback_api');

amqp.connect('amqp://rabbitmq', function(err, conn) {
    conn.createChannel(function(err, ch) {
        var q = 'product';
ch.assertExchange(q, 'fanout', {durable: false});


ch.assertQueue('', {exclusive: true}, function(err, p) {
      console.log(" [*] Waiting for messages in %s. To exit press CTRL+C", p.queue);
      ch.bindQueue(p.queue, q, '');

      ch.consume(p.queue, function(msg) {
        console.log(" [x] Received PRODUCT ID - %s", msg.content.toString());
      }, {noAck: true});
    });


 //       ch.assertQueue(q, {durable: false});
   //     console.log(" [*] Waiting for messages in %s. To exit press CTRL+C", q);
     //   ch.consume(q, function(msg) {
       //     console.log(" [x] Received PRODUCT ID - %s", msg.content.toString());
//        }, {noAck: true});
    });
}); 
 

 */
 
