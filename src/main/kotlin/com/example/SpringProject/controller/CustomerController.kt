package com.example.SpringProject.controller


import com.example.SpringProject.model.Customer
import com.example.SpringProject.service.CustomerService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/customers")
class CustomerController(private val service: CustomerService) {

    @GetMapping
    suspend fun getAll(): List<Customer> = service.getAll()

    @GetMapping("/{id}")
    suspend fun getById(@PathVariable id: Int): Customer? = service.getById(id)

    @PostMapping
    suspend fun create(@RequestBody customer: Customer): Customer = service.create(customer)

    @PutMapping("/{id}")
    suspend fun update(@PathVariable id: Int, @RequestBody customer: Customer): Customer? =
        service.update(id, customer)

    @DeleteMapping("/{id}")
    suspend fun delete(@PathVariable id: Int): Boolean = service.delete(id)
}
