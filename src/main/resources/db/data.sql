use clasificacion;
INSERT INTO productos (nombre, descripcion, categoria, precio, subpartida)
SELECT 'Tornillo', 'tornillo rosca fina', 'motores', 5, '8431439000'
WHERE NOT EXISTS (
    SELECT 1 FROM productos WHERE nombre = 'Tornillo' AND subpartida = '8431439000'
);

INSERT INTO productos (nombre, descripcion, categoria, precio, subpartida)
SELECT 'cable', 'Cable de datos', 'telecomunicaciones', 100, '851720901000'
WHERE NOT EXISTS (
    SELECT 1 FROM productos WHERE nombre = 'cable' AND subpartida = '851720901000'
);

INSERT INTO productos (nombre, descripcion, categoria, precio, subpartida)
SELECT 'mouse', 'Mouse inalambrico', 'computadores', 20, '2932202010'
WHERE NOT EXISTS (
    SELECT 1 FROM productos WHERE nombre = 'mouse' AND subpartida = '2932202010'
);

INSERT INTO productos (nombre, descripcion, categoria, precio, subpartida)
SELECT 'teclado', 'Teclado retroilminado', 'computadores', 200, '4016931000'
WHERE NOT EXISTS (
    SELECT 1 FROM productos WHERE nombre = 'teclado' AND subpartida = '4016931000'
);

INSERT INTO productos (nombre, descripcion, categoria, precio, subpartida)
SELECT 'computador', 'procesador de datos', 'computadores', 1500, '9010909090'
WHERE NOT EXISTS (
    SELECT 1 FROM productos WHERE nombre = 'computador' AND subpartida = '9010909090'
);

INSERT INTO usuarios (identificacion, nombre, email, password)
SELECT '123', 'Admin', 'admin@example.com', SHA2('123', 256)
    WHERE NOT EXISTS (
    SELECT 1 FROM usuarios WHERE email = 'admin@example.com'
);
INSERT INTO usuarios (identificacion, nombre, email, password)
SELECT '1234', 'root', 'root@example.com', SHA2('123', 256)
    WHERE NOT EXISTS (
    SELECT 1 FROM usuarios WHERE email = 'root@example.com'
);
