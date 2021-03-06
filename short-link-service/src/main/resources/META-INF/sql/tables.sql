create table ShortLink_ShortLinkEntry (
	uuid_ VARCHAR(75) null,
	shortLinkEntryId LONG not null primary key,
	createDate DATE null,
	modifiedDate DATE null,
	originalURL STRING null,
	shortURL VARCHAR(100) null,
	httpStatusCode INTEGER,
	active_ BOOLEAN
);