insert into public.product_group (id, name)
values  (1, 'Group 1'),
        (2, 'Group 2'),
        (3, 'Group 3'),
        (4, 'Group 5');

insert into public.product (id, name, group_id)
values  (8, 'product 1', 1),
        (9, 'product 2', 1),
        (10, 'product 3', 1),
        (11, 'product 4', 2),
        (12, 'product 5', 3),
        (13, 'product 6', 3),
        (14, 'product 7', 4),
        (15, 'product 8', 4),
        (16, 'product 9', 2),
        (17, 'product 10', 4);