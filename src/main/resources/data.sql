insert into address  (street1, street2, city, province, zip_code) values ('street1' ,'street2','Innopolis','Tatarstan','430500');
insert into address  (street1, street2, city, province, zip_code) values ('street1' ,'street2','Kazan','Tatarstan','430500');
insert into address  (street1, street2, city, province, zip_code) values ('street1' ,'street2','Naberezhnie Chelny','Tatarstan','430500');

insert into restaurants  (name, email, phone_number) values ('Amore','mail@amore.com','88008008070');
insert into restaurants  (name, email, phone_number) values ('Dolche vita','mail@dolche.com','88008008080');
insert into restaurants  (name, email, phone_number) values ('Georgia','mail@georgia.com','88008008090');

insert into product_categories  (name) values ('Dessert');
insert into product_categories  (name) values ('First course');
insert into product_categories  (name) values ('Main course');
insert into product_categories  (name) values ('Drinks');

insert into products  (name, description, restaurant_id, cost_price, product_category_id) values ('Steake','Tasty steake',1L,300.0,3L);
insert into products  (name, description, restaurant_id, cost_price, product_category_id) values ('Orange juice','Fresh orange juice',1L,300.0,4L);
insert into products  (name, description, restaurant_id, cost_price, product_category_id) values ('Potato soupe','description for soup',1L,300.0,2L);
insert into products  (name, description, restaurant_id, cost_price, product_category_id) values ('Borsch','description for soup',1L,300.0,2L);
insert into products  (name, description, restaurant_id, cost_price, product_category_id) values ('Pancake','description for dessert',1L,300.0,1L);
insert into products  (name, description, restaurant_id, cost_price, product_category_id) values ('Ice-cream','Ice-cream with chocolate',1L,300.0,1L);

