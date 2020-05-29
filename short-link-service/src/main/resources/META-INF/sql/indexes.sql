create index IX_52A1B216 on ShortLink_ShortLinkEntry (modifiedDate);
create index IX_58EBE563 on ShortLink_ShortLinkEntry (originalURL[$COLUMN_LENGTH:4000$]);
create index IX_2A06AD2 on ShortLink_ShortLinkEntry (shortURL[$COLUMN_LENGTH:100$]);
create index IX_9219F049 on ShortLink_ShortLinkEntry (uuid_[$COLUMN_LENGTH:75$]);