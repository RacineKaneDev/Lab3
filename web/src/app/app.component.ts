import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { CommonModule, CurrencyPipe } from '@angular/common';
import { Product } from './models/product.model';
import { ProductService } from './services/product.service';


@Component({
  selector: 'app-root',
  imports: [RouterOutlet, CurrencyPipe, CommonModule],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css',
})
export class AppComponent {
  title = 'web';
  products: Product[] = [];
  constructor(private productService: ProductService) {
    this.loadProducts();
  }
  loadProducts(): void {
    this.productService.getProducts().subscribe((data) => {
      this.products = data;
    });
  }

}
