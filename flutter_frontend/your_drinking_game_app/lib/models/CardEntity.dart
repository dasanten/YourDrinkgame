import 'package:flutter/foundation.dart';

import '../dataBase/CardSetDB.dart';

@immutable
class CardEntity {
  final int id;
  final String content;
  final bool active;
  final String workshopId;
  final int cardSetId;

  const CardEntity({
    this.id,
    this.workshopId,
    @required this.content,
    @required this.active,
    @required this.cardSetId,
  });

  Map<String, dynamic> toMap() => <String, dynamic>{
        CardSetDB.COLUMN_CARD_CONTENT: content,
        CardSetDB.COLUMN_CARD_ACTIVE: active ? 1 : 0,
        CardSetDB.COLUMN_CARD_WORKSHOP_ID: workshopId,
        CardSetDB.COLUMN_CARD_CARD_SET_ID: cardSetId,
        if (id != null) CardSetDB.COLUMN_CARD_ID: id,
      };

  factory CardEntity.fromMap(Map<String, dynamic> map) => CardEntity(
        id: map[CardSetDB.COLUMN_CARD_ID] as int,
        content: map[CardSetDB.COLUMN_CARD_CONTENT] as String,
        active: map[CardSetDB.COLUMN_CARD_ACTIVE] as int == 1,
        workshopId: map[CardSetDB.COLUMN_CARD_WORKSHOP_ID] as String,
        cardSetId: map[CardSetDB.COLUMN_CARD_CARD_SET_ID] as int,
      );

  CardEntity copyWith({
    int id,
    String content,
    bool active,
  }) =>
      CardEntity(
        content: content ?? this.content,
        active: active ?? this.active,
        cardSetId: cardSetId,
        id: id ?? this.id,
        workshopId: workshopId,
      );
}
