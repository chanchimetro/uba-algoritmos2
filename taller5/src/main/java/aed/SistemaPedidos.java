package aed;

public class SistemaPedidos {
    ABB<Pedido> _abb;
    ListaEnlazada<ABB.HandleABB> _lista;

    public SistemaPedidos(){
        _abb = new ABB<>();
        _lista = new ListaEnlazada<>();
    }

    public void agregarPedido(Pedido pedido){
        ABB.HandleABB handle = _abb.insertar(pedido);
        _lista.agregarAtras(handle);
    }

    public Pedido proximoPedido(){
        Pedido pedido = null;
        
        if (_lista.longitud() > 0) {
            ABB.HandleABB handle = _lista.obtener(0);
            pedido = (Pedido) handle.valor();
            handle.eliminar();
            _lista.eliminar(0);
        }
        
        return pedido;
    }

    public Pedido pedidoMenorId(){
        return _abb.minimo();
    }

    public String obtenerPedidosEnOrdenDeLlegada(){
        String string = "";
        
        for (int i = 0; i < _lista.longitud(); i++) {
            Pedido p = (Pedido) _lista.obtener(i).valor();
            string += p.toString();
            if (i  < _lista.longitud()-1) {
                string += ", ";
            }
        }

        return "[" + string + "]";
    }

    public String obtenerPedidosOrdenadosPorId(){
        return _abb.toString();
    }
}