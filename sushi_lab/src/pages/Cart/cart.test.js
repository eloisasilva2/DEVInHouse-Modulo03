import { render } from '@testing-library/react';
import Cart from './Cart';
import { CartContext } from '../../contexts/CartContext';

describe('Cart component', () => {
  it('should render the cart items and total', () => {
    // Define mock data for the CartContext
    const cart = [
      {
        itemId: 1,
        product: {
          name: 'Product 1',
          image: 'product1.jpg',
          price: 10
        },
        quantity: 2,
        subTotalFormatted: '$20.00'
      },
      {
        itemId: 2,
        product: {
          name: 'Product 2',
          image: 'product2.jpg',
          price: 5
        },
        quantity: 1,
        subTotalFormatted: '$5.00'
      }
    ];
    const totalCart = {
      totalFormatted: '$25.00'
    };

    // Create a mock CartContext with the mock data
    const mockCartContext = {
      cart,
      totalCart
    };

    // Render the Cart component with the mock CartContext
    const table = getByTestId('table-cart');
    expect(table).toBeInTheDocument();

    
    const rows = table.querySelectorAll('tbody tr');
    expect(rows.length).toBe(2);

    const firstRow = rows[0];
    expect(firstRow).toHaveTextContent('Product 1');
    expect(firstRow).toHaveTextContent('$20.00');

    const secondRow = rows[1];
    expect(secondRow).toHaveTextContent('Product 2');
    expect(secondRow).toHaveTextContent('$5.00');

    // Test that the total is rendered
    const total = getByText('Total: $25.00');
    expect(total).toBeInTheDocument();
  });
});