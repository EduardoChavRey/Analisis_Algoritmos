use Analisis; 


--RESET DATABASE 
/*Disable Constraints & Triggers*/
exec sp_MSforeachtable 'ALTER TABLE ? NOCHECK CONSTRAINT ALL'
exec sp_MSforeachtable 'ALTER TABLE ? DISABLE TRIGGER ALL'

/*Perform delete operation on all table for cleanup*/
SET NUMERIC_ROUNDABORT OFF;
EXEC sp_MSForEachTable 'SET QUOTED_IDENTIFIER ON; DELETE FROM ?'

/*Enable Constraints & Triggers again*/
exec sp_MSforeachtable 'ALTER TABLE ? CHECK CONSTRAINT ALL'
exec sp_MSforeachtable 'ALTER TABLE ? ENABLE TRIGGER ALL'

/*Reset Identity on tables with identity column*/
exec sp_MSforeachtable 'IF OBJECTPROPERTY(OBJECT_ID(''?''), ''TableHasIdentity'') = 1 BEGIN DBCC CHECKIDENT (''?'',RESEED,0) END'


IF OBJECT_ID('NombresArticulos', 'U') IS NOT NULL
BEGIN
DROP TABLE NombresArticulos;
END
go
IF OBJECT_ID('Descripcion1', 'U') IS NOT NULL
BEGIN
DROP TABLE Descripcion1;
END
go
IF OBJECT_ID('Marca', 'U') IS NOT NULL
BEGIN
DROP TABLE Marca;
END
go

	Create Table NombresArticulos (Nombre nvarchar(50));
	INSERT INTO NombresArticulos(Nombre) VALUES 
	('Zapato'),('Bateria'),('Camisa'),('Mouse'),('Cuadro'),('Reloj'),('Teclado'),('Disco'),
	('Telefono'),('Celular'),('Tinte para el pelo'),('Maquina de afeitar'),('Tijera'),('Goma'),
	('Cuaderno de Examen'),('LightSaber'),('Cargador'),('Mantel'),('Bombillo'),('Birra'),('Cobija'),
	('Analgésico'),('USB Driver'),('Tabaco'),('Cola para el pelo'),('Lente');

	CREATE TABLE Descripcion1 (Nombre nvarchar(50));
	INSERT INTO Descripcion1(Nombre) VALUES 
	('Azul'),('Blanco'),('Verde'),('Negro'),('Rosado'),('Gris'),('Morado'),('Celeste'),('Rojo'),
	('Amarillo'),('Mugo'),('Metalico'),('Platinado'),('Radioactivo'),('Grande'),('Pequeño'),('Alto'),
	('Bajo'),('Increible');

	CREATE TABLE Marca  (Nombre nvarchar(50));
	INSERT INTO Marca(Nombre) VALUES 
	('Intel'),('HP'),('Bioware'),('EA'),('Ubisoft'),('Microsoft'),('GigaSoft'),('MicroHard'),('Epson'),
	('LSD'),('Panasonic'),('LG'),('Aniplex'),('Gainax'),('LucasArts'),('TEC'),('ArTEC'),('ComunicaTEC'),
	('EnergizaTEC'),('CargaTEC'),('EmbriagaTEC'),('MiraTEC'),('FumaTEC'),('AlmacenaTEC'),('AdomeceTEC'),
	('BisTEC');



drop procedure CreateClients
go
create procedure CreateClients(@NumberOfClients int)
as
begin
	declare @Nombre nvarchar(50)
	declare @PApellido nvarchar(50)
	declare @SApellido nvarchar(50)
	declare @NCedula int
	declare @PuntosAcumulados int
	declare @Numero int

	set @Numero=1;
	set @PuntosAcumulados=0;
	while (@NumberOfClients>0)
		Begin
		set @Nombre = CONCAT ('Nombre ',@Numero);
		set @PApellido = CONCAT ('Apellido ',@Numero);
		set @SApellido = CONCAT ('Segundo Apellido ',@Numero);
		set @NCedula = 999999999*RAND();

		insert into clientes (Nombre,PrimerApellido,SegundoApellido,NumeroCedula,PuntosAcumulados) VALUES 
		(@Nombre,@PApellido,@SApellido,@NCedula,@PuntosAcumulados);
		
		set @Numero = @Numero + 1;
		set @NumberOfClients = @NumberOfClients - 1
	end
	
end
go

drop procedure CreateCategories
go

create procedure CreateCategories(@CantidadCategorias int)
as
BEGIN
	DECLARE @Nombre nvarchar(50);
	DECLARE @CategoriaSize int;
	while @CantidadCategorias > 0
		BEGIN
			SELECT  @CategoriaSize = count(*) from categoriaarticulos;
			Set @Nombre = CONCAT ('Categoria #',@CategoriaSize+1)
			INSERT INTO categoriaarticulos(Nombre) VALUES (@Nombre)
			SET @CantidadCategorias = @CantidadCategorias -1;
		END
END
go


drop procedure CreateArticles;
go

create procedure CreateArticles(@CantidadArticulos int)
as
begin
	Declare @Numero int = 1;
	Declare @Nombre nvarchar (45);
	Declare @Precio bigint;
	Declare @CantidadExistencia int;
	Declare @Descripcion nvarchar(100);
	Declare @IdCategoria int;
	Declare @NombreParte1 nvarchar(45);
	Declare @NombreParte2 nvarchar(45);
	Declare @NombreParte3 nvarchar(45);
	while (@CantidadArticulos>0) 
		BEGIN
			Select top 1 @NombreParte1 = Nombre from NombresArticulos order by NEWID();
			Select top 1 @NombreParte2 = Nombre from Descripcion1 order by NEWID();
			Select top 1 @NombreParte3 = Nombre from Marca order by NEWID();
			SET @Nombre = CONCAT (@NombreParte1,' '+@NombreParte2+' marca '+@NombreParte3)
			SET @Precio = 32000 * RAND() + 500;
			SET @Descripcion = CONCAT ('Este es el articulo numero ',@Numero);
			SET @CantidadExistencia = RAND()*100+1
			Select top 1 @IdCategoria = idCategoriaArticulo from categoriaarticulos order by NEWID();
			insert into articulos(NombreArticulo, Descripcion, PrecioActual, CantidadExistencia, idCategoriaArticulo)
			VALUES (@Nombre,@Descripcion,@Precio,RAND()*10+1,@IdCategoria )
			SET @CantidadArticulos = @CantidadArticulos -1 ;
		END
end
go





drop procedure CreateConditionsByArticles;
go

create procedure CreateConditionsByArticles(@CantidadCondiciones int)
as
begin
	DECLARE @IdArticulo BIGINT;
	While (@CantidadCondiciones>0)
	BEGIN
		Select top 1 @IdArticulo = IdArticulo from articulos order by NEWID();
		DECLARE @MinArticulos INT= RAND()*5+1;
		INSERT INTO condicionesporarticulos(idArticulo,MinimoCantidadArticulo) 
		VALUES (@IdArticulo,@MinArticulos)
		SET @CantidadCondiciones=@CantidadCondiciones-1;
	END
end
go


drop procedure CreateConditionsByAmount;
go

create procedure CreateConditionsByAmount(@CantidadCondiciones int)
as
begin

	While (@CantidadCondiciones>0)
		BEGIN
		DECLARE @MinArticulos INT= RAND()*30000+8000;
		INSERT INTO condicionespormontodecompra(MinimoMontoDeCompra) VALUES (@MinArticulos)
		SET @CantidadCondiciones=@CantidadCondiciones-1;
	END
end
go



drop procedure CreateConditionsByPoints;
go

create procedure CreateConditionsByPoints(@CantidadCondiciones int)
as
begin
	While (@CantidadCondiciones>0)
	BEGIN 
		DECLARE @MinPuntos INT= RAND()*3000+8000;
		INSERT INTO condicionesporpuntos(MinimoDePuntos) VALUES (@MinPuntos)
		SET @CantidadCondiciones=@CantidadCondiciones-1;
	END
end
go


drop procedure CreateDiscounts;
go

create procedure CreateDiscounts(@CantidadDescuentos int)
as
begin
	DECLARE @IdArticulo BIGINT;
	While (@CantidadDescuentos>0)
	BEGIN
		Select top 1 @IdArticulo = IdArticulo from articulos order by NEWID();
		DECLARE @Porcentaje INT= RAND()*99+1;
		INSERT INTO descuentos(idArticulo,PorcentajeDescuento) VALUES (@IdArticulo,@Porcentaje)
		SET @CantidadDescuentos=@CantidadDescuentos-1;
	END
end
go	



drop procedure InsertPromo;
go

create procedure InsertPromo (@TablaCondicion int, @IdCondicion int,@IdDescuento int)
as
BEGIN
	Print (' ')
	Print (CONCAT(@TablaCondicion,' ',@idCondicion,' ',@IdDescuento))
	Print (' ')
	DECLARE @NumeroDePromocion int;
	select @NumeroDePromocion = count(*) from promociones;
	SET IDENTITY_INSERT descuentosporpromociones ON;
IF (@TablaCondicion=1)
	BEGIN
		INSERT INTO promociones(Descripcion) VALUES 
		(CONCAT('Descripcion de Promocion ',@NumeroDePromocion));
		INSERT INTO condicionesarticulosporpromociones(idCondicion,idPromocion) VALUES (@IdCondicion,@NumeroDePromocion)
		INSERT INTO descuentosporpromociones(idDescuento,idPromocion) VALUES (@IdDescuento,@NumeroDePromocion)
	END
IF (@TablaCondicion=2)
	BEGIN
		INSERT INTO promociones(Descripcion) VALUES 
		(CONCAT('Descripcion de Promocion ',@NumeroDePromocion));
		INSERT INTO condicionesMontoporpromociones(idCondicion,idPromocion) VALUES (@IdCondicion,@NumeroDePromocion)
		INSERT INTO descuentosporpromociones(idDescuento,idPromocion) VALUES (@IdDescuento,@NumeroDePromocion)
	END
IF (@TablaCondicion=3)
	BEGIN 
		INSERT INTO promociones(Descripcion) VALUES 
		(CONCAT('Descripcion de Promocion ',@NumeroDePromocion));
		INSERT INTO condicionesPuntosporpromociones(idCondicion,idPromocion) VALUES (@IdCondicion,@NumeroDePromocion)
		INSERT INTO descuentosporpromociones(idDescuento,idPromocion) VALUES (@IdDescuento,@NumeroDePromocion)
	END
	SET IDENTITY_INSERT descuentosporpromociones OFF;
END
go


drop procedure CreatePromos;
go

create procedure CreatePromos(@CantidadPromos int)
as
begin
	DECLARE @ProbabilidadDeDescuentoMayor float= 0.3;
	DECLARE @ProbabilidadDeDescuentoRandom float= 0.05;
	DECLARE @Random float;
	Declare @IdCondicion int;
	Declare @IdDescuento int;
	Declare @MontoDescuento float;
	Declare @MontoCondicion float;
	Declare @NumeroDePromocion int;
	Declare @ForaneaCondicion int;
	Declare @EleccionCondicion int;
	DECLARE @PromoSize Int;
	select @PromoSize = count(*) from promociones; 

	While (@PromoSize < @CantidadPromos)
	BEGIN
		select @PromoSize = count(*) from promociones; 
		set @Random= RAND();
		set @EleccionCondicion = RAND()*3+1;
		
		Select top 1 @IdDescuento = IdDescuento from descuentos order by NEWID();
		SELECT @MontoDescuento= PrecioActual from articulos where idArticulo= 
		(select idArticulo from descuentos where idDescuento= @IdDescuento) * 
		(select PorcentajeDescuento from descuentos where idDescuento=@IdDescuento)/100;

		IF (@EleccionCondicion=1)
			BEGIN
				Select top 1 @IdCondicion = idCondicionPorArticulos from condicionesporarticulos order by NEWID();
				set @MontoCondicion= (select precioActual from articulos where idArticulo=
				(select idArticulo from condicionesporarticulos where 
				idCondicionPorArticulos = @IdCondicion))
			END
		IF (@EleccionCondicion=2)
			BEGIN
				select @MontoCondicion =  MinimoMontoDeCompra from condicionespormontodecompra
				where idCondicionPorMontoDeCompra = @IdCondicion;
			END
		IF (@EleccionCondicion=3)
			BEGIN
				select @MontoCondicion =  MinimoDePuntos from condicionesporpuntos
				where idCondicionPorPuntos = @IdCondicion;
			END
		print (Concat('Random: ',@Random));print(Concat('CantidadPromos: ',@PromoSize));
		print(Concat('MontoCondicion: ',@MontoCondicion));print(Concat('MontoDescuento: ',@MontoDescuento));
		print (Concat(' ',' '))
		IF (@Random < @ProbabilidadDeDescuentoRandom) 
				IF (@MontoCondicion > @MontoDescuento)  BEGIN
						exec InsertPromo @EleccionCondicion,@IdCondicion,@IdDescuento END
 				ELSE
						CONTINUE
		ELSE
			IF (@Random < @ProbabilidadDeDescuentoMayor) 
				IF (@MontoCondicion> @MontoDescuento * 2) BEGIN
					exec InsertPromo @EleccionCondicion,@IdCondicion,@IdDescuento END
				ELSE
					CONTINUE
			ELSE 
				IF (@MontoCondicion> @MontoDescuento * 4) BEGIN
					exec InsertPromo @EleccionCondicion,@IdCondicion,@IdDescuento END
				ELSE
					CONTINUE
	END
END
go

drop procedure NewClient
go
create procedure NewClient(@pNombre nvarchar(45),@pPrimerApellido nvarchar(45),
							@pSegundoApellido nvarchar(45),@pNumeroCedula bigint,@pPuntosAcumulados int)
as
begin
	insert into clientes (Nombre,PrimerApellido,SegundoApellido,NumeroCedula,PuntosAcumulados) VALUES 
		(@pNombre,@pPrimerApellido,@pSegundoApellido,@pNumeroCedula,@pPuntosAcumulados);
end
go

drop procedure NewCategory
go
create procedure NewCategory(@pNombre nvarchar(45))
as
begin
	insert into caracteristicasarticulo(Nombre) VALUES (@pNombre)
end
go


drop procedure NewArticle
go
create procedure NewArticle(@pNombreArticulo nvarchar(45),@pCategoria nvarchar(45),@pPrecioActual FLOAT,
							@pDescripcion nvarchar(450),@pCantidadExistencia int)
as
begin
	DECLARE @IDCategoria int;
	SELECT @IDCategoria = idCategoriaArticulo from categoriaarticulos where Nombre=@pCategoria;

	IF (@IDCategoria IS NULL) 
		BEGIN
			PRINT ('No existe tal categoria.')
		END

	ELSE
		BEGIN
	insert into articulos(NombreArticulo,PrecioActual,Descripcion,CantidadExistencia,idCategoriaArticulo) VALUES 
		(@pNombreArticulo,@pPrecioActual,@pDescripcion,@pCantidadExistencia,@IDCategoria);
		END
end
go

drop procedure NewDiscount;
go
create procedure NewDiscount(@pNombreArticulo nvarchar(45),@PorcentajeDescuento INT)
as
begin
	DECLARE @IdArticulo int;
	SELECT @IdArticulo = idArticulo from articulos where idArticulo=@IdArticulo;
	IF (@IdArticulo IS NULL) 
		BEGIN
			PRINT ('No existe tal articulo.')
		END

	ELSE
		BEGIN
			insert into descuentos(PorcentajeDescuento,idArticulo) VALUES (@PorcentajeDescuento,@IdArticulo);
		END
end
go


drop procedure NewFactura;
go
create procedure NewFactura(@pNombreCliente nvarchar(45),@pPrimerApellido nvarchar(45),
@pSegundoApellido nvarchar(45)) 
AS 
BEGIN
	DECLARE @IdCliente int;
	SELECT @IdCliente = idCliente from clientes where Nombre=@pNombreCliente 
	and PrimerApellido=@pPrimerApellido and SegundoApellido=@pSegundoApellido;
	IF (@IdCliente IS NULL) 
		BEGIN
			PRINT ('Este cliente no esta registrado en la base de datos.')
		END

	ELSE
		BEGIN
			INSERT INTO facturas(idCliente,Fecha,MontoTotal,Impuestos,Descuento) 
			 VALUES (@IdCliente, CURRENT_TIMESTAMP,0,0,0)
		END
END
GO

drop procedure AddDetailsToFactura
go
create procedure AddDetailsToFactura(
									@pNombreArticulo nvarchar(45),
									@pCantidad int
) AS 
BEGIN
	DECLARE @pIdFactura BIGINT;
	SET @pIdFactura= IDENT_CURRENT('facturas');
	DECLARE @IdArticulo BIGINT;
	SELECT @IdArticulo = idArticulo from articulos where @pNombreArticulo=NombreArticulo;
	IF (@IdArticulo IS NULL) 
		BEGIN
			PRINT ('No existe tal articulo.')
		END
	ELSE
		BEGIN
			Declare @Stock int;
			select @Stock = CantidadExistencia from articulos where idArticulo = @IdArticulo;
			IF (@Stock>= @pCantidad)
			BEGIN
				Declare @PrecioPorUnidad float;
				select @PrecioPorUnidad = PrecioActual from articulos where idArticulo = @IdArticulo; 
				Declare @TotalPorArticulo float= @PrecioPorUnidad*@pCantidad;
				Declare @PuntosObjetidos int;
				SET @PuntosObjetidos = @TotalPorArticulo/3;
				
				insert into detallesFactura(idFactura,idArticulo,Descripcion,CantidadDeArticulo,
				PrecioUnitario,TotalPorArticulo) VALUES 
				(@pIdFactura,@IdArticulo,'Compra regular de cliente',@pCantidad,@PrecioPorUnidad,@TotalPorArticulo);

				update articulos set CantidadExistencia=CantidadExistencia-@pCantidad 
					where idArticulo = @IdArticulo;

				update clientes set PuntosAcumulados=PuntosAcumulados+@PuntosObjetidos where 
					idCliente = (select idCliente from facturas where idFactura=@pIdFactura)

				update facturas set MontoTotal=MontoTotal+@TotalPorArticulo+@TotalPorArticulo*0.13,
									Impuestos=MontoTotal*0.13
					where idFactura=@pIdFactura;


			END
		END
END
go


drop procedure AddDetailsToFacturaPromocion;
go
create procedure AddDetailsToFacturaPromocion(
									@pIdPromocion BigINt
) AS 
BEGIN
	DECLARE @pIdFactura BIGINT;
	SET @pIdFactura= IDENT_CURRENT('facturas');
	DECLARE @IdArticulo BIGINT;
	SELECT @IdArticulo = descuentos.idArticulo from articulos 
	inner join descuentos ON descuentos.idArticulo = articulos.idArticulo
	inner join descuentosporpromociones ON descuentosporpromociones.idPromocion = @pIdPromocion;
	DECLARE @IdDescuento INT;
	SELECT @IdDescuento = idDescuento from descuentosporpromociones 
	inner join promociones ON promociones.idPromocion = @pIdPromocion;
	IF (@IdArticulo IS NULL) 
		BEGIN
			PRINT ('No existe tal articulo.')
		END
	ELSE
		BEGIN
			Declare @Stock int;
			select @Stock = CantidadExistencia from articulos where idArticulo = @IdArticulo;
			IF (@Stock> 0)
			BEGIN
				Declare @PrecioPorUnidad float;
				select @PrecioPorUnidad = PrecioActual from articulos where idArticulo = @IdArticulo; 
				Declare @TotalPorArticulo float= @PrecioPorUnidad;
				Declare @PuntosObjetidos int;
				SET @PuntosObjetidos = @TotalPorArticulo/3;
				DECLARE @Descuento int;
				Select @Descuento=PorcentajeDescuento from descuentos where idDescuento=@IdDescuento
				DECLARE @RebajoDescuento float;
				SET @RebajoDescuento = @TotalPorArticulo*@Descuento/100; 
				
				insert into detallesFactura(idFactura,idArticulo,Descripcion,CantidadDeArticulo,
				PrecioUnitario,TotalPorArticulo) VALUES 
				(@pIdFactura,@IdArticulo,CONCAT('Promocion ',@pIdPromocion),1,@PrecioPorUnidad,@TotalPorArticulo);

				update articulos set CantidadExistencia=CantidadExistencia-1 
					where idArticulo = @IdArticulo;

				update facturas set MontoTotal=MontoTotal+(@TotalPorArticulo-@RebajoDescuento)
				+(@TotalPorArticulo-@RebajoDescuento)*0.13,
									Impuestos=MontoTotal*0.13,
									Descuento=@RebajoDescuento
					where idFactura=@pIdFactura;


			END
		END
END
go


drop procedure possiblePromos ()
go

create procedure possiblePromos 
as
BEGIN
	DECLARE @pIdFactura BIGINT;
	SET @pIdFactura= IDENT_CURRENT('facturas');
	DECLARE @pCliente BIGINT;
	SELECT @pCliente= idCliente from facturas where idFactura=@pIdFactura;
	DECLARE @pPuntosCliente BIGINT;
	Select @pPuntosCliente = PuntosAcumulados from clientes where idCliente = @pCliente
	DECLARE @MontoTotal float;
	SELECT @MontoTotal = MontoTotal from facturas where idFactura=@pIdFactura;
	DECLARE @pIdDetalleFactura BIGINT;
	Select @pIdDetalleFactura= idDetalleFactura from detallesfactura where idFactura = @pIdFactura;
	DECLARE @pPuntosCliente int;
	Select @pPuntosCliente = PuntosAcumulados from clientes where idCliente = @pCliente

	select 
	promociones.idPromocion,
	ISNULL(condicionesporarticulos.idArticulo,0) AS IdArticulo,
	ISNULL(condicionesporarticulos.MinimoCantidadArticulo,0) AS MinimoUnidadesArticulo,
	ISNULL(condicionespormontodecompra.MinimoMontoDeCompra,0) MinimoMontoDeCompra,
	ISNULL(condicionesporpuntos.MinimoDePuntos,0) AS MinimoPuntos
	 from promociones
		left join condicionesArticulosPorPromociones ON promociones.idPromocion = condicionesArticulosPorPromociones.idPromocion
		left join condicionesporarticulos ON condicionesporarticulos.idCondicionPorArticulos = condicionesArticulosPorPromociones.idCondicion
		left join condicionesMontoPorPromociones ON promociones.idPromocion = condicionesMontoPorPromociones.idPromocion
		left join condicionespormontodecompra ON condicionespormontodecompra.idCondicionPorMontoDeCompra = condicionesMontoPorPromociones.idCondicion
		left join condicionesPuntosPorPromociones ON promociones.idPromocion = condicionesPuntosPorPromociones.idPromocion
		left join condicionesporpuntos ON condicionesporpuntos.idCondicionPorPuntos = condicionesPuntosPorPromociones.idCondicion
		where	@pPuntosCliente<=condicionesporpuntos.MinimoDePuntos AND
				@MontoTotal<= condicionespormontodecompra.MinimoMontoDeCompra AND
				@pPuntosCliente <= condicionesporpuntos.MinimoDePuntos ;


END
go




drop procedure Articles
go
create procedure Articles
as 
begin
	select * from articulos
end 
go

drop procedure ArticlesbyId
go
create procedure ArticlesbyId (@IdArticulo bigint)
as 
begin
	select * from articulos where idArticulo=@IdArticulo;
end 
go

drop procedure ArticlesbyName
go
create procedure ArticlesbyName (@NombreArticulo nvarchar(45))
as 
begin
	select * from articulos where NombreArticulo like CONCAT('%',@NombreArticulo,'%') ;
end 
go


/*    Consulta que saca todos la informacion de todas las promociones    */
select 
	promociones.idPromocion,
	ISNULL(condicionesporarticulos.idArticulo,0) AS IdArticulo,
	ISNULL(condicionesporarticulos.MinimoCantidadArticulo,0) AS MinimoUnidadesArticulo,
	ISNULL(condicionespormontodecompra.MinimoMontoDeCompra,0) MinimoMontoDeCompra,
	ISNULL(condicionesporpuntos.MinimoDePuntos,0) AS MinimoPuntos
	 from promociones
	left join condicionesArticulosPorPromociones ON promociones.idPromocion = condicionesArticulosPorPromociones.idPromocion
	left join condicionesporarticulos ON condicionesporarticulos.idCondicionPorArticulos = condicionesArticulosPorPromociones.idCondicion
	left join condicionesMontoPorPromociones ON promociones.idPromocion = condicionesMontoPorPromociones.idPromocion
	left join condicionespormontodecompra ON condicionespormontodecompra.idCondicionPorMontoDeCompra = condicionesMontoPorPromociones.idCondicion
	left join condicionesPuntosPorPromociones ON promociones.idPromocion = condicionesPuntosPorPromociones.idPromocion
	left join condicionesporpuntos ON condicionesporpuntos.idCondicionPorPuntos = condicionesPuntosPorPromociones.idCondicion





exec CreateCategories 25;
exec CreateArticles 25;
exec CreateClients 25;
exec CreateConditionsByArticles 25;
exec CreateConditionsByAmount 25;
exec CreateConditionsByPoints 25;
exec CreateDiscounts 50;
exec CreatePromos 100;


