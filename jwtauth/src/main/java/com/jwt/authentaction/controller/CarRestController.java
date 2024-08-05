package com.jwt.authentaction.controller;

@RestController
@RequestMapping("/v1")
public class CarRestController {
	@Autowired
	CarService carservice;

	@GetMapping("/cars")
	public ResponseEntity<List<Car>> getAllCars() {
		return ResponseEntity.ok().body(carservice.findAllCars());

	}

	@GetMapping("/cars/owned")
	@PostFilter("filterObject.owner==authentication.name")
	public List<Car> getCarsOwnedBy() {
		return carservice.findAllCars();

	}

	@PostMapping("/cars")
	public ResponseEntity<Car> saveCars(@RequestBody Car newCar, Authentication auth) {
		System.out.println(newCar.getCarName() + "  " + auth.getName());
		return ResponseEntity.status(HttpStatus.CREATED).body((carservice.saveCar(newCar)));

	}

	@GetMapping("/cars/{id}")
	public ResponseEntity<Car> getCarById(@PathVariable("id") int carId) {
		return ResponseEntity.ok().body(carservice.findCarById(carId).get());

	}

	@PutMapping("/cars/{id}")
	public ResponseEntity<Car> updateCar(@PathVariable("id") int carId, @RequestBody Car newCar) {
		return ResponseEntity.ok().body(carservice.updateCar(carId, newCar));

	}

	@DeleteMapping("/cars/{id}")
	public ResponseEntity<Object> deleteCar(@PathVariable("id") int carId) {
		carservice.deleteCar(carId);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

	}

	@GetMapping("/cars/search")
	public ResponseEntity<?> userDetails(Authentication auth, @RequestParam("cname") String cName) {
		System.out.println(auth.getName().toString());
		Car car = carservice.findByCarName(cName);
		if (car == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("car not found");
		}
		return ResponseEntity.ok().body(car);

	}

}
