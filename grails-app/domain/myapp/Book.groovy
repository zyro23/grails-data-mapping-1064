package myapp


class Book {

	static belongsTo = [author: Author]

	String name

	static constraints = {
		author unique: ["name"]
	}

}
