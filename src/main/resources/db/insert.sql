set foreign_key_checks = 0;
truncate table post;

insert into post(`id`, `title`,`post_body`, `author`)
values(11, 'The Verdict', 'lorem ipsum', 'Titobi'),
(12, 'The Stranger', 'lorem ipsum', 'Jolayemi'),
(13, 'Against All Odds', 'lorem ipsum', 'Fasoyin');
set foreign_key_checks = 1;