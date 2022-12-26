package ma.enset.inventoryservicecommand.aggregates;

import commands.category.CreateCategoryCommand;
import dtos.CategoryRequestDTO;
import events.CategoryCreatedEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

@Aggregate
public class CategoryAggregate {
    @AggregateIdentifier
    private Long id;
    private String name;
    private String description;

    public CategoryAggregate() {
    }

    @CommandHandler
    public CategoryAggregate(CreateCategoryCommand command){
        AggregateLifecycle.apply( new CategoryCreatedEvent(
                command.getId(),
                command.getPayload()
        ));
    }

    @EventSourcingHandler
    public void on(CategoryCreatedEvent event){
        CategoryRequestDTO payload = event.getPayload();
        this.id = event.getId();
        this.name = payload.getName();
        this.description = payload.getDescription();
    }
}
