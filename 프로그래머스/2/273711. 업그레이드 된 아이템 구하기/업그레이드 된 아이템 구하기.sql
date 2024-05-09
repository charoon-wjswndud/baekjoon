SELECT info.ITEM_ID, info.ITEM_NAME, info.RARITY
FROM ITEM_INFO info 
INNER JOIN ITEM_TREE tree
    ON info.ITEM_ID = tree.ITEM_ID
WHERE tree.PARENT_ITEM_ID IN (
                            SELECT info.ITEM_ID
                            FROM ITEM_INFO info 
                            INNER JOIN ITEM_TREE tree
                                ON info.ITEM_ID = tree.ITEM_ID
                            WHERE info.RARITY = 'RARE')
ORDER BY info.ITEM_ID DESC;