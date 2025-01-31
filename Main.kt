class Cliente(
    val nombre: String,
    val direccion: String,
    val email: String,
    val telefono: String
) {
    val pedidos = mutableListOf<Pedido>()

    fun añadirPedido(pedido: Pedido) {
        pedidos.add(pedido)
    }
}

class Pedido(
    val id: Int,
    val fecha: Fecha,
    var estado: EstadoPedido,
    val productos: List<Pair<Producto, Int>>,
    val pagos: MutableList<Pago> = mutableListOf()
) {

    fun calcularCosteTotal(): Double {
        var total = 0.0
        for (productoPair in productos) {
            val producto = productoPair.first
            val cantidad = productoPair.second
            total += producto.precio * cantidad
            total += producto.precio * producto.impuesto * cantidad
        }
        return total
    }

    fun actualizarEstado(nuevoEstado: EstadoPedido) {
        estado = nuevoEstado
    }

    fun verificarStock(): Boolean {
        for (productoPair in productos) {
            val producto = productoPair.first
            val cantidad = productoPair.second
            if (producto.stock < cantidad) {
                return false
            }
        }
        return true
    }
}

class Producto(
    val nombre: String,
    val descripcion: String,
    val precio: Double,
    val impuesto: Double,
    var stock: Int
) {

    fun actualizarStock(cantidad: Int) {
        stock -= cantidad
    }

    fun verificarStock(cantidad: Int): Boolean {
        return stock >= cantidad
    }
}

class Pago(
    val id: Int,
    val fechaPago: Fecha,
    val formaPago: FormaPago
) {
    fun registrarPago(pago: Pago, pedido: Pedido) {
        pedido.pagos.add(pago)
        pedido.actualizarEstado(EstadoPedido.PGDO)
    }

    fun registrarPlazoPago(plazo: Fecha, cantidad: Double) {
    }
}

enum class FormaPago(val descripcion: String) {
    CARD("Pago con tarjeta") {
        override fun realizarVerificacion(parametro: String): Boolean {
            // Lógica para validar tarjeta con el parametro (puede ser número y fecha)
            println("Validando tarjeta: $parametro")
            return true
        }
    },
    CASH("Pago en efectivo") {
        override fun realizarVerificacion(parametro: String): Boolean {
            // Lógica para verificar el tipo de moneda
            println("Verificando pago en efectivo con moneda: $parametro")
            return true
        }
    },
    CHEQUE("Pago con cheque") {
        override fun realizarVerificacion(parametro: String): Boolean {
            // Lógica para verificar el cheque con el parametro (puede ser nombre o banco)
            println("Verificando cheque con banco: $parametro")
            return true
        }
    };

    abstract fun realizarVerificacion(parametro: String): Boolean
}

class Fecha(
    val dia: Int,
    val mes: Int,
    val anio: Int
) {

    fun esFechaValida(): Boolean {
        return dia in 1..31 && mes in 1..12 && anio >= 1900
    }
}

enum class EstadoPedido {
    PDTE,
    PGDO,
    PCDO,
    ENVD,
    ENTGDO
}

fun main() {
    val fecha = Fecha(31, 1, 2025)

    val producto1 = Producto("Camiseta", "Camiseta de algodón", 19.99, 0.21, 50)
    val producto2 = Producto("Pantalón", "Pantalón de mezclilla", 39.99, 0.21, 30)

    val pedido = Pedido(
        id = 1,
        fecha = fecha,
        estado = EstadoPedido.PDTE,
        productos = listOf(Pair(producto1, 2), Pair(producto2, 1))
    )

    val costeTotal = pedido.calcularCosteTotal()
    println("Coste Total: $$costeTotal")

    if (pedido.verificarStock()) {
        println("Stock suficiente.")
    } else {
        println("No hay suficiente stock.")
    }

    val pago = Pago(1, fecha, FormaPago.CARD)
    pago.formaPago.realizarVerificacion("1234 5678 9101 1121")

    pedido.actualizarEstado(EstadoPedido.PGDO)
    println("Estado actualizado: ${pedido.estado}")
}
