# CASE STUDY - RETAIL SALES MANAGEMENT SYSTEM

# Customer Class created
class Customer:
    # Created dictionary with the name customers
    customers = {}

    def __init__(self, customer_id, name, contact_info, loyalty_points):
        # Initializer to set instance variables
        self.customer_id = customer_id
        self.name = name
        self.contact_info = contact_info
        self.loyalty_points = loyalty_points

    def add_customer(self):
        # Method to add a customer to the customers dictionary
        Customer.customers[self.customer_id] = self
        print("Customer added successfully.")

    def update_customer(self):
        # Method to update an existing customer's details
        Customer.customers[self.customer_id] = self
        print("Customer details updated successfully.")

    def delete_customer(self):
        # Method to delete a customer from the customers dictionary
        del Customer.customers[self.customer_id]
        print("Customer deleted successfully.")

# Transaction class created
class Transaction:
    # Created dictionary with the name transactions
    transactions = {}

    def __init__(self, transaction_id, customer_id, product_name, quantity_sold, sale_amount):
        # Initializer to set instance variables
        self.transaction_id = transaction_id
        self.customer_id = customer_id
        self.product_name = product_name
        self.quantity_sold = quantity_sold
        self.sale_amount = sale_amount

    def add_transaction(self):
        # Method to add a transaction to the transactions dictionary
        Transaction.transactions[self.transaction_id] = self
        print("Transaction recorded successfully.")

# Main function to run the application
def main():
    
    while True:
        # Display menu options
        print("\n1. Add Customer")
        print("2. Update Customer")
        print("3. Delete Customer")
        print("4. View Customer List")
        print("5. Record Transactions")
        print("6. View Transaction List")
        print("7. Generate Top Customers Report")
        print("8. Exit")

        # Get user choice
        choice = input("Enter your choice: ")

        try:
            if choice == '1':
                # Add a new customer
                customer_id = input("Enter Customer ID: ")
                # Checks whether the customer id already exists or not because each customer has unique customer id
                if customer_id in Customer.customers:
                    raise ValueError("Customer ID already exists.")
                name = input("Enter Name: ")
                contact_info = input("Enter Contact Info: ")
                loyalty_points = int(input("Enter Loyalty Points: "))
                customer = Customer(customer_id, name, contact_info, loyalty_points)
                customer.add_customer()

            elif choice == '2':
                # Update an existing customer
                customer_id = input("Enter Customer ID: ")
                # Checks whether the customer id exists or not to continue with updaton
                if customer_id not in Customer.customers:
                    raise ValueError("Customer ID does not exist.")
                name = input("Enter Name: ")
                contact_info = input("Enter Contact Info: ")
                loyalty_points = int(input("Enter Loyalty Points: "))
                customer = Customer(customer_id, name, contact_info, loyalty_points)
                customer.update_customer()

            elif choice == '3':
                # Delete a customer
                customer_id = input("Enter Customer ID: ")
                # Raises a value error if the customer id does not exist
                if customer_id not in Customer.customers:
                    raise ValueError("Customer ID does not exist.")
                customer = Customer(customer_id, "", "", 0)  
                customer.delete_customer()

            elif choice == '4':
                # Prints list of all customers
                print("Customers List:")
                print("Customer ID \t\t Customer Name \t\t Contact Info \t\t Loyalty Points")
                for customer in Customer.customers.values():
                    print(f"{customer.customer_id} \t\t\t {customer.name} \t\t\t {customer.contact_info} \t\t\t {customer.loyalty_points}")

            elif choice == '5':
                # Record a new transaction
                transaction_id = input("Enter Transaction ID: ")
                # Checking whether the Transaction ID already exists or not 
                if transaction_id in Transaction.transactions:
                    raise ValueError("Transaction ID already exists.")
                # If transaction ID already exists raises value error else continues with adding new transaction
                customer_id = input("Enter Customer ID: ")
                product_name = input("Enter Product Name: ")
                quantity_sold = int(input("Enter Quantity Sold: "))
                sale_amount = float(input("Enter Sale Amount: "))
                transaction = Transaction(transaction_id, customer_id, product_name, quantity_sold, sale_amount)
                transaction.add_transaction()

            elif choice == '6':
                # Print list of all transactions
                print("Transaction List: ")
                print("Transaction ID: \t Customer ID: \t Product Name: \t Quantity Sold: \t Sale Amount:")
                for transaction in Transaction.transactions.values():
                    print(f"{transaction.transaction_id} \t\t\t {transaction.customer_id} \t\t {transaction.product_name} \t\t {transaction.quantity_sold} \t\t\t {transaction.sale_amount}")

            elif choice == '7':
                # Generate a report of top customers based on loyalty points
                print("List of Customers with Loyalty points greater than 100:")
                print("Customer ID \t\t Customer Name \t\t Contact Info \t\t Loyalty Points")
                for customer in Customer.customers.values():
                    if customer.loyalty_points > 100:
                        print(f"{customer.customer_id} \t\t\t {customer.name} \t\t\t {customer.contact_info} \t\t\t {customer.loyalty_points}")

            elif choice == '8':
                # Exit the program
                print("Exiting...")
                break

            else:
                # Handle invalid menu choices
                print("Invalid choice. Please try again.")

        except ValueError as e:
            # Handle value errors (e.g., invalid input)
            print(f"Error: {e}")
            
        except Exception as e:
            # Handle any other unexpected errors
            print(f"An unexpected error occurred: {e}")

if __name__ == "__main__":
    main()
