package model

class User private constructor(
    val name: String,
    val age: Int?,
    val email: String?,
) {
    class Builder {
        private var name: String? = null
        private var age: Int? = null
        private var email: String? = null

        fun name(name: String) = apply { this.name = name }

        fun age(age: Int) = apply { this.age = age }

        fun email(email: String) = apply { this.email = email }

        fun build(): User {
            val finalName = name ?: IllegalArgumentException()
            return User(finalName.toString(), age, email)
        }
    }

    companion object {
        fun from(name: String): Builder = Builder().name(name)
    }
}
