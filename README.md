# short-links

This was a simple Service Builder application for administering redirects in Liferay. The redirects are implemented through a servlet filter.

Redirects were stored as follows in the database

```
MySQL [lportal]> select * from ShortLink_ShortLinkEntry limit 10;
+--------------------------------------+------------------+---------------------+---------------------+-------------------------------------------------------------------------------------------------------------------------------------------------------------------+-----------------------+----------------+---------+
| uuid_                                | shortLinkEntryId | createDate          | modifiedDate        | originalURL                                                                                                                                                       | shortURL              | httpStatusCode | active_ |
+--------------------------------------+------------------+---------------------+---------------------+-------------------------------------------------------------------------------------------------------------------------------------------------------------------+-----------------------+----------------+---------+
| eab4cf31-0c27-4a13-b404-968367f6b36d |              101 | 2017-05-06 01:36:38 | 2017-05-12 20:30:21 | https://web.liferay.com/tour-de-liferay/robot                                                                                                                     | tour-de-liferay/robot |            301 |       1 |
| eb57013b-b1c4-44b3-8f5b-6e8647de1976 |              102 | 2017-05-06 01:41:08 | 2017-05-12 20:31:53 | https://discover.liferay.com/digital_experience_platforms?utm_source=emerce_ad&utm_medium=display&utm_content=ready_future&utm_campaign=70170000000uxkf           | emerce                |            301 |       1 |
| ed12e601-0b15-4eea-a219-e6f807c704fc |              103 | 2017-05-06 01:41:50 | 2017-09-18 16:41:35 | https://discover.liferay.com/digital-success-webinar?utm_source=eday&utm_medium=content&utm_content=card&utm_campaign=70170000000vK74                             | eday                  |            301 |       1 |
| bc4bf21b-dab1-4b46-9dbf-3c20e0cfd06d |              104 | 2017-05-06 01:42:45 | 2017-05-12 20:53:57 | https://discover.liferay.com/digital_experience_platforms?utm_source=event_digital_first&utm_medium=display&utm_content=ready_future&utm_campaign=70170000000uxkf | digitalfirst          |            301 |       1 |
| 032c80c8-2137-4b3d-b9ff-c6ab8885f5f6 |              105 | 2017-05-06 01:43:09 | 2017-05-12 20:54:13 | https://www.liferay.com/resource/illinois-student-assistance-commission                                                                                           | isac                  |            301 |       1 |
| 94c5a721-b4ba-4ad6-b890-584d96ca2ffe |              108 | 2017-05-06 01:49:15 | 2017-05-12 20:55:25 | https://www.liferay.com/resource?folderId=1645493&title=Liferay+Buyers+Guide+Checklist                                                                            | get-checklist         |            301 |       1 |
| 5b044c8c-f1ef-4c10-ae91-15e66a23b8d0 |              110 | 2017-05-06 01:52:33 | 2017-05-12 20:55:32 | https://web.liferay.com/web/events2016/brazil?_ga=2.220537816.1124888591.1494035473-305552205.1481774868                                                          | brazil2016            |            301 |       1 |
| e94cde2b-abc3-419c-918a-748bb28c951f |              111 | 2017-05-06 01:53:08 | 2017-05-12 20:55:37 | https://web.liferay.com/web/events2016/italy/recap                                                                                                                | italy2016             |            301 |       1 |
| 1e6314a1-9d49-4139-b927-36401c0cf536 |              112 | 2017-05-06 01:53:48 | 2017-05-12 20:55:59 | http://discover.liferay.com/dxp-roadshow-budapest                                                                                                                 | budapest              |            301 |       1 |
| 5763f5a8-fb36-4785-ac52-fa2b46bb406c |              114 | 2017-05-06 01:55:21 | 2017-05-12 20:56:16 | https://web.liferay.com/web/events2016/modconf                                                                                                                    | modconf               |            301 |       1 |
+--------------------------------------+------------------+---------------------+---------------------+-------------------------------------------------------------------------------------------------------------------------------------------------------------------+-----------------------+----------------+---------+
10 rows in set (0.001 sec)
```

In 7.3 we replaced this with the new Redirections feature.
