package ma.enset.inventoryservicecommand.aggregates;

import commands.product.CreateProductCommand;
import dtos.ProductRequestDTO;
import enums.ProductStatus;
import events.product.ProductCreatedEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

@Aggregate
public class ProductAggregate {
    @AggregateIdentifier
    private Long id;
    private String name;
    private double price;
    private int quantity;
    private ProductStatus status;
    private Long categoryId;

    public ProductAggregate() {
    }

    @CommandHandler
    public ProductAggregate(CreateProductCommand command){
        AggregateLifecycle.apply( new ProductCreatedEvent(
                command.getId(),
                command.getPayload()
        ));
    }

    @EventSourcingHandler
    public void on(ProductCreatedEvent event){
        ProductRequestDTO payload = event.getPayload();
        this.id = event.getId();
        this.name = payload.getName();
        this.price = payload.getPrice();
        this.quantity = payload.getQuantity();
        this.status = payload.getStatus();
        this.categoryId = payload.getCategoryId();
    }
}
