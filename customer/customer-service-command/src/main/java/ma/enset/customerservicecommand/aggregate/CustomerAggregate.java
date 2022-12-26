package ma.enset.customerservicecommand.aggregate;

import commands.customer.CreateCustomerCommand;
import events.CustomerCreatedEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

@Aggregate
public class CustomerAggregate {
    @AggregateIdentifier
    private String id;
    private String name;
    private String address;
    private String email;
    private String tel;

    public CustomerAggregate() {
    }

    @CommandHandler
    public CustomerAggregate(CreateCustomerCommand command){
        AggregateLifecycle.apply( new CustomerCreatedEvent(
                command.getId(),
                command.getName(),
                command.getAddress(),
                command.getEmail(),
                command.getTel()) );
    }

    @EventSourcingHandler
    public void on(CustomerCreatedEvent event){
        this.id = event.getId();
        this.name = event.getName();
        this.address = event.getAddress();
        this.email = event.getEmail();
        this.tel = event.getTel();
    }
}
