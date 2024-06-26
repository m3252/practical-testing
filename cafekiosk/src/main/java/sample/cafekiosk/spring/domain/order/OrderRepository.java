package sample.cafekiosk.spring.domain.order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    @Query("SELECT o FROM Order o WHERE o.registeredDateTime >= :startDateTime and o.registeredDateTime < :endDateTime" +
            " AND o.orderStatus = :orderStatus")
    List<Order> findOrderBy(@Param("startDateTime") LocalDateTime startDateTime,
                            @Param("endDateTime") LocalDateTime endDateTime,
                            @Param("orderStatus") OrderStatus orderStatus);

}
