import 'dart:async';

import 'package:flutter/foundation.dart';
import 'package:path/path.dart';
import 'package:sqflite/sqflite.dart';

import '../models/CardEntity.dart';
import '../models/CardSetEntity.dart';

class CardSetDB {
  // ignore_for_file: constant_identifier_names
  static const String TABLE_CARD_SET = "card_set";

  static const String COLUMN_CARD_SET_ID = "id";
  static const String COLUMN_CARD_SET_NAME = "name";
  static const String COLUMN_CARD_SET_DESCRIPTION = "description";
  static const String COLUMN_CARD_SET_ACTIVE = "active";
  static const String COLUMN_CARD_SET_WORKSHOP_ID = "workshop_id";

  static const String TABLE_CARD = "card";

  static const String COLUMN_CARD_ID = "id";
  static const String COLUMN_CARD_CONTENT = "content";
  static const String COLUMN_CARD_ACTIVE = "active";
  static const String COLUMN_CARD_WORKSHOP_ID = "workshop_id";
  static const String COLUMN_CARD_CARD_SET_ID = "card_set_id";

  CardSetDB._();
  static final CardSetDB cardSetDB = CardSetDB._();
  Database _database;

  Future<Database> get database async {
    if (_database != null) {
      return _database;
    }

    return _database = await createDataBase();
  }

  Future<Database> createDataBase() async {
    final dbPath = await getDatabasesPath();

    return openDatabase(
      join(dbPath, 'card_set_database.db'),
      version: 1,
      onCreate: (database, version) async {
        await database.execute(
          """
          CREATE TABLE $TABLE_CARD_SET (
              $COLUMN_CARD_SET_ID INTEGER PRIMARY KEY,
              $COLUMN_CARD_SET_NAME TEXT,
              $COLUMN_CARD_SET_DESCRIPTION TEXT,
              $COLUMN_CARD_SET_ACTIVE INTEGER,
              $COLUMN_CARD_SET_WORKSHOP_ID TEXT)
        """,
        );
        await database.execute(
          """
            CREATE TABLE $TABLE_CARD (
              $COLUMN_CARD_ID INTEGER PRIMARY KEY,
              $COLUMN_CARD_CONTENT TEXT,
              $COLUMN_CARD_ACTIVE INTEGER,
              $COLUMN_CARD_WORKSHOP_ID TEXT,
              $COLUMN_CARD_CARD_SET_ID INTEGER,
              FOREIGN KEY($COLUMN_CARD_CARD_SET_ID) REFERENCES $TABLE_CARD_SET($COLUMN_CARD_SET_ID)
                ON DELETE NO ACTION ON UPDATE NO ACTION)""",
        );
      },
    );
  }

  //CARD SET DB ACTIONS

  Future<List<CardSetEntity>> getCardSets() async {
    final db = await database;
    final cardSets = await db.query(
      TABLE_CARD_SET,
      columns: [
        COLUMN_CARD_SET_ID,
        COLUMN_CARD_SET_NAME,
        COLUMN_CARD_SET_DESCRIPTION,
        COLUMN_CARD_SET_ACTIVE,
        COLUMN_CARD_SET_WORKSHOP_ID
      ],
    );

    return cardSets
        .map<CardSetEntity>((e) => CardSetEntity.fromMap(e))
        .toList();
  }

  Future<CardSetEntity> insertCardSet(CardSetEntity cardSet) async {
    final db = await database;
    final id = await db.insert(TABLE_CARD_SET, cardSet.toMap());

    return cardSet.copyWith(
      id: id,
    );
  }

  Future<int> deleteCardSet(int id) async {
    final db = await database;

    return db.delete(
      TABLE_CARD_SET,
      where: "$COLUMN_CARD_SET_ID = ?",
      whereArgs: [id],
    );
  }

  Future<int> updateCardSet(CardSetEntity cardSet) async {
    final db = await database;

    return db.update(
      TABLE_CARD_SET,
      cardSet.toMap(),
      where: "$COLUMN_CARD_SET_ID =  ?",
      whereArgs: [cardSet.id],
    );
  }

  //CARD DB ACTIONS
  Future<List<CardEntity>> getCards(int cardSetId) async {
    final db = await database;

    final cards = await db.query(
      TABLE_CARD,
      columns: [
        COLUMN_CARD_ID,
        COLUMN_CARD_CONTENT,
        COLUMN_CARD_ACTIVE,
        COLUMN_CARD_WORKSHOP_ID,
        COLUMN_CARD_CARD_SET_ID
      ],
      where: "$COLUMN_CARD_CARD_SET_ID = ?",
      whereArgs: [cardSetId],
    );

    return cards.map<CardEntity>((e) => CardEntity.fromMap(e)).toList();
  }

  Future<CardEntity> insertCard(CardEntity card) async {
    final db = await database;
    final id = await db.insert(TABLE_CARD, card.toMap());

    return card.copyWith(
      id: id,
    );
  }

  Future<List<CardEntity>> insertCardList(
    List<CardEntity> cardEntityList,
  ) async {
    cardEntityList.forEach((card) async {
      card = await insertCard(card);
    });
    return cardEntityList;
  }

  Future<int> deleteCard(int id) async {
    final db = await database;

    return db.delete(
      TABLE_CARD,
      where: "$COLUMN_CARD_ID = ?",
      whereArgs: [id],
    );
  }

  Future<int> updateCard(CardEntity card) async {
    final db = await database;

    return db.update(
      TABLE_CARD,
      card.toMap(),
      where: "$COLUMN_CARD_ID = ?",
      whereArgs: [card.id],
    );
  }

  Future<List<CardEntity>> getActiveCards() async {
    final db = await database;
    final cardList = <CardEntity>[];

    await db
        .query(
          TABLE_CARD_SET,
          columns: [
            COLUMN_CARD_SET_ID,
            COLUMN_CARD_SET_NAME,
            COLUMN_CARD_SET_DESCRIPTION,
            COLUMN_CARD_SET_ACTIVE,
            COLUMN_CARD_SET_WORKSHOP_ID
          ],
          where: "$COLUMN_CARD_SET_ACTIVE = ?",
          whereArgs: [1],
        )
        .then(
          (value) => value.forEach(
            (cardSet) async {
              final newCards = await db.query(
                TABLE_CARD,
                columns: [
                  COLUMN_CARD_ID,
                  COLUMN_CARD_CONTENT,
                  COLUMN_CARD_ACTIVE,
                  COLUMN_CARD_WORKSHOP_ID,
                  COLUMN_CARD_CARD_SET_ID
                ],
                where:
                    "$COLUMN_CARD_CARD_SET_ID = ? AND $COLUMN_CARD_ACTIVE = ?",
                whereArgs: [cardSet[COLUMN_CARD_SET_ID], 1],
              );
              if (newCards.isNotEmpty) {
                cardList.addAll(newCards.map((e) => CardEntity.fromMap(e)));
                debugPrint("TEST 1");
              }
            },
          ),
        );

    return cardList;
  }
}
