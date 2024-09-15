package org.example;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("example-unit");
        EntityManager em = emf.createEntityManager();

        try{
            em.getTransaction().begin();

            /*Factura factura1 = Factura.builder()
                    .numero(12)
                    .fecha("10/08/2020")
                    .build();

            Domicilio dom = Domicilio.builder()
                    .nombreCalle("San Martin")
                    .numero(1222)
                    .build();

            Cliente cliente = Cliente.builder()
                    .nombre("Pablo")
                    .apellido("Muñoz")
                    .dni(15245778)
                    .build();
            cliente.setDomicilio(dom);

            factura1.setCliente(cliente);

            Categoria perecederos = Categoria.builder()
                    .denominacion("Perecederos")
                    .build();
            Categoria lacteos = Categoria.builder()
                    .denominacion("Lacteos")
                    .build();
            Categoria limpieza = Categoria.builder()
                    .denominacion("Limpieza")
                    .build();

            Articulo art1 = Articulo.builder()
                    .cantidad(200)
                    .denominacion("Yogurt Ser sabor Frutilla")
                    .precio(20)
                    .build();
            Articulo art2 = Articulo.builder()
                    .cantidad(300)
                    .denominacion("Detergente Magistral")
                    .precio(80)
                    .build();

            art1.getCategorias().add(perecederos);
            art1.getCategorias().add(lacteos);
            art2.getCategorias().add(limpieza);

            DetalleFactura detalle1 = DetalleFactura.builder()

                    .build();

            detalle1.setArticulo(art1);
            detalle1.setCantidad(2);
            detalle1.setSubtotal(40);

            factura1.getDetalles().add(detalle1);

            DetalleFactura detalle2 = DetalleFactura.builder()

                    .build();

            detalle2.setArticulo(art2);
            detalle2.setCantidad(1);
            detalle2.setSubtotal(80);

            factura1.getDetalles().add(detalle2);

            factura1.setTotal(120);*/

            Factura factura1 = em.find(Factura.class, 1L);

            //factura1.setNumero(85);

            em.remove(factura1);

            em.flush();

            em.getTransaction().commit();

        }catch (Exception e){
            em.getTransaction().rollback();
        }

        em.close();
        emf.close();
    }
}
