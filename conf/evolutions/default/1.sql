# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table comment (
  id                            bigint auto_increment not null,
  topic_id                      bigint,
  parent_id                     bigint,
  text                          TEXT,
  constraint pk_comment primary key (id)
);

create table topic (
  id                            bigint auto_increment not null,
  title                         varchar(255),
  contents                      TEXT,
  constraint pk_topic primary key (id)
);

alter table comment add constraint fk_comment_topic_id foreign key (topic_id) references topic (id) on delete restrict on update restrict;
create index ix_comment_topic_id on comment (topic_id);

alter table comment add constraint fk_comment_parent_id foreign key (parent_id) references comment (id) on delete restrict on update restrict;
create index ix_comment_parent_id on comment (parent_id);


# --- !Downs

alter table comment drop constraint if exists fk_comment_topic_id;
drop index if exists ix_comment_topic_id;

alter table comment drop constraint if exists fk_comment_parent_id;
drop index if exists ix_comment_parent_id;

drop table if exists comment;

drop table if exists topic;

