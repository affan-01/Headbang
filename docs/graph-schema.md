# Music Recommendation Engine
## Graph Schema – v1.0

Designed for:
- Multi-user system
- Listening history import
- Collaborative filtering
- Genre-based traversal
- Hybrid scoring (future)

Last Updated: 2026-03-04

| Node   | Properties                                                                     | Unique    |
| ------ | ------------------------------------------------------------------------------ | --------- |
| User   | userId, displayName, country, importedAt                                       | userId    |
| Song   | spotifyId, title, popularity, durationMs, danceability, energy, valence, tempo | spotifyId |
| Artist | spotifyId, name, followers                                                     | spotifyId |
| Genre  | name                                                                           | name      |


| From   | Relationship | To     | Properties                    |
| ------ | ------------ | ------ | ----------------------------- |
| User   | LISTENS_TO   | Song   | playCount, lastPlayed, weight |
| Song   | PERFORMED_BY | Artist | —                             |
| Artist | IN_GENRE     | Genre  | —                             |


CONSTRAINTS-----------------------------------

CREATE CONSTRAINT user_unique IF NOT EXISTS
FOR (u:User)
REQUIRE u.userId IS UNIQUE;

CREATE CONSTRAINT song_unique IF NOT EXISTS
FOR (s:Song)
REQUIRE s.spotifyId IS UNIQUE;

CREATE CONSTRAINT artist_unique IF NOT EXISTS
FOR (a:Artist)
REQUIRE a.spotifyId IS UNIQUE;

CREATE CONSTRAINT genre_unique IF NOT EXISTS
FOR (g:Genre)
REQUIRE g.name IS UNIQUE;

INDEXES-----------------------------------

CREATE INDEX song_title_index IF NOT EXISTS
FOR (s:Song)
ON (s.title);

CREATE INDEX artist_name_index IF NOT EXISTS
FOR (a:Artist)
ON (a.name);

CREATE INDEX song_popularity_index IF NOT EXISTS
FOR (s:Song)
ON (s.popularity);

CREATE INDEX user_country_index IF NOT EXISTS
FOR (u:User)
ON (u.country);