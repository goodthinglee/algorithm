SELECT fi.id, fni.fish_name, fi.length
FROM fish_info fi
JOIN fish_name_info fni ON fi.fish_type = fni.fish_type
WHERE fi.length = (
    SELECT MAX(length)
    FROM fish_info
    WHERE fish_type = fi.fish_type
)
ORDER BY fi.id ASC;
