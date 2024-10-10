-- 코드를 작성해주세요
SELECT ii.item_id, item_name, rarity
FROM item_info ii
LEFT JOIN item_tree it
ON ii.item_id = it.parent_item_id
WHERE it.item_id IS NULL
ORDER BY ii.item_id DESC